package step03;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class HttpServlet extends GenericServlet {
  @Override
  public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
    HttpServletRequest httpReq = (HttpServletRequest) request;
    HttpServletResponse httpResp = (HttpServletResponse) response;
    this.service(httpReq, httpResp);
  }
  
  public abstract void service(
      HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException;
}
