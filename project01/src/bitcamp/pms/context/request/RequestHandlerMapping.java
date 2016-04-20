package bitcamp.pms.context.request;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import bitcamp.pms.annotation.Controller;
import bitcamp.pms.annotation.RequestMapping;
import bitcamp.pms.context.ApplicationContext;

public class RequestHandlerMapping {
  ApplicationContext appContext;
  HashMap<String,RequestHandler> handlerMap = new HashMap<>();
  
  public RequestHandlerMapping(ApplicationContext appContext) {
    this.appContext = appContext;
    
    Map<String,Object> controllersMap = 
        appContext.getBeansWithAnnotation(Controller.class);
    
    Collection<Object> controllers = controllersMap.values();
    
    Method[] methods = null;
    RequestMapping anno = null;
    RequestMapping classAnno = null;
    String baseName = null;
    
    for (Object controller : controllers) {
      classAnno = controller.getClass().getAnnotation(RequestMapping.class);
      if (classAnno != null) {
        baseName = classAnno.value();
      } else {
        baseName = "";
      }
      
      methods = controller.getClass().getMethods();
      
      for (Method m : methods) {
        anno = m.getAnnotation(RequestMapping.class);
        
        if (anno == null)
          continue;
        
        handlerMap.put(baseName + anno.value(), new RequestHandler(m, controller));
        //System.out.printf("%s--> %s\n", controller.getClass().getName(), m.getName());
      }
    }
  }

  public RequestHandler getRequestHandler(String name) {
    return handlerMap.get(name);
  }
  
}
