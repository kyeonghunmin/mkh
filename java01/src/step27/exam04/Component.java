// 애노테이션 유지 정책 변경하기 2

package step27.exam04;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

// => 유지 정책을 RUNTIME으로 변경 (기본 : CLASS)
// RUNTIME은 .class 파일에 포함되며, 실행시 꺼낼 수 있다.
@Retention(RetentionPolicy.RUNTIME)
public @interface Component {
  String value(); // <-- 속성을 정의할 때 메서드처럼 정의한다.
}
