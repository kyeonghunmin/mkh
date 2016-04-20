// 애노테이션 유지 정책 변경하기

package step27.exam02;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

// => 유지 정책을 SOURCE로 변경 (기본 : CLASS)
@Retention(RetentionPolicy.SOURCE)
public @interface Component {
  String value(); // <-- 속성을 정의할 때 메서드처럼 정의한다.
}
