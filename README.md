## [NEXTSTEP 플레이그라운드의 미션 진행 과정](https://github.com/next-step/nextstep-docs/blob/master/playground/README.md)

## 피드백 시청전 느낀점

- 일급 객체를 cars 에 썼는데 큰 효용을 모르겠음 뭔가 메소드를 만들어야 하는 양이 많아져서 별로인거 같은데
- 앞으로 가는 조건을 객체로 만들었는데 이거 자체는 좋은거같은데 테스트하기가 애매함 

## 피드백 시청 후
- 테스트하기 애매하다한게 테스트를 위해서 전략 객체 생성시점을 객체그래프에서 상위로 계속 올리는게 찜찜했는데 이는 테스트를 쉽게만드는 방법중 하나로 배움 
  - => 잘한 것 같음
- 테스트를 위해서 무조건 전진하는 전략 `AlwaysTrueCondition` 같은거를 만들 었는데 이렇게 하지말고 람다를 넣는 방법도 있음 
  - => 근데 재사용 관점에서 따로 만드는것도 나쁘지 않다고 생각함
- 일급 콜렉션과 원시값 매핑에 회의적이였는데 복잡해질수록 밸리데이션에서도 의미가 있어지고 이렇게하다보면 로직이 객체로 옮겨지는게 핵심 같음
  - => 조금이라도 복잡해질 여지가 있으면 하자.
- 로직이나 구조적으로는 강의랑 거의 똑같아서 뿌듯. (원시값 래핑만 하면될듯)

## Tip

- 경주 완료된 상태의 car 를 테스트 하기 위해..
  - 생성자 오버로딩으로 완료된 상태의 차 만들 수 있게 => 이건 좀 아닌것 같음 프로덕션에서 실수로 쓸수 있을거 같음
  - `FinishedCar` 같은 테스트용 클래스 생성 => 괜찮은듯
- 함수 시그니쳐를 바꾸지 않고 리팩토링 하기 (심코드)

```java
public boolean method1() { return condition() }
protected boolean condition() { ... }
 ```

```java
Car car = new Car() {
    @Override
    protected boolean condition() { return true; }
}
```

이런식으로 protected로 놓고 테스트단에서 오버라이딩하여 쓸수 있음