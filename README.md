# Operating_System
컴퓨터공학과 운영체제 정리입니다.

## 1.1 운영체제란?

```
운영체제란 Operating System(OS) 컴퓨터를 운영하기 위한 수법과 절차를 모은 소프트웨어 체계입니다.
운영체제의 가장 기본적인 역할 중의 하나는 사용자로 하여금 하드웨어인 입.출력 장치를 편리하게 사용할 수 있게 하는 것이다.
만약 운영체제가 없다면 일반 사용자는 키보드, 마우스, 모니터, 프린터 등을 사용할 수 없어서 컴퓨터는 무용지물이 된다.

운영체제는 시스템 콜이라고 부르는 서비스 요청 접속 창구를 라이브러리 형태로 제공한다.
사용자는 시스템 콜 라이브러리를 호출하는 프로그램을 작성하여 실행함으로써 운영체제가 제공하는 서비스를 받을 수 있다.
자주 사용되는 운영체제 서비스는 미리 작성되어 시스템에 탑재되어 있는 프로그램을 실행시켜 호출할 수 있는데 이러한 프로그램을 시스템 명령어라 부른다.
```

## 1.2 운영체제의 유형(발전과정)

### 1. 단일 프로그래밍 일괄 처리 시스템(Single-stream Batch(일괄로 묶다) Processing)
```
단일 프로그래밍 일괄 처리 시스템 환경에서 사용자는 컴퓨터에 접근할 수 없었으므로 프로그램을 천공 카드에
작성하여 관리자에게 제출하였고, 운영체제는 오직 하나의 프로그램만을 적재하여 차례차례 실행시켰다.

적재된 프로그램이 오직 하나 밖에 없었으므로, 사용자 프로그램이 입출력을 요구했을 때 운영체제는 입출력이
완료될 때까지 프로세서를 기다려야 했으므로 허비하는 시간(Idle Time)이 많았다.
```

### 2. 다중 프로그래밍 일괄 처리 시스템(Multiprogramming Batch Programming)
```
다중 프로그래밍 일괄 처리 시스템에서는 사용자 프로그램을 동시에 여러 개 적재시켜 실행중인 프로그램이
입출력을 요구하면 그 입출력 작업이 진행되는 동안에 다른 프로그램을 실행시켜줌으로써 프로세서의 유후 시간을 줄였다.

그러나 적재된 프로그램들의 완료 시간이 다른 프로그램의 입출력 요구 빈도에 따라 큰 영향을 받으므로 각 프로그램들의 완료시간
편차가 심하다.
```

### 3. 시분할 시스템(Time-Sharing System)
```
시분할 시스템은 여러 개의 프로그램을 짧은 시간(타임 퀀텀) 동안 조금씩 번갈아 가면서 처리함으로써 사용자에게
시스템을 독차지하고 있다는 느낌을 준다.

시분할 시스템은 다수의 사용자들이 단말기를 통해서 컴퓨터에 동시 접속하는 대화적 처리 환경에 적합하다.
```

### 4. 병렬 처리 시스템(Parallel Processing Systems)
```
병렬 처리 시스템은 여러 개의 처리기(CPU)를 이용하여 여러 개의 프로그램들을 병렬로 처리한다.
병럴 처리 시스템의 목적은 성능 향상과 신뢰성 향상(결함 허용)에 있다.
병렬 처리(Parallel Processing)은 어느 시점을 기준으로 보았을 때 2개 이상의 프로그램을 처리하는 것을 말하고,
병행 처리(Concurrent Processing)는 어느 시점을 기준으로 보았을 때는 오직 하나의 프로그램만을 처리하지만,
이들을 번갈아 처리함으로써 일정 기간 동안 결국 여러 개의 프로그램을 처리하는 것을 말한다.

병렬 처리를 위한 다중 처리기 시스템은 분산 처리 시스템의 일종으로 강결합(Tightly-coupled System)이라 부르기도 한다.
다중 처리기 시스템은 처리기들 사이의 버스 연결 방식에 따라 단일 공유 버스, 다중 버스, 크로스바 스위치 버스, 계층적 버스
다중 포트 메모리 버스 등으로 분류된다.

처리기들이 독립적이지 않고 주어진 기계 명령어에 대하여 서로 긴밀하게 협조하여 서로 다른 데이터에 대한 동일한 연산 처리를
수행하는 다중 처리기 형태가 있는데 배열(혹은 벡터) 처리기가 그 대표적인 예이다.
```

### 병렬 처리 시스템의 종류
```
병렬 처리 시스템은 대칭형과 비대칭형으로 나뉘는데 대칭형은 CPU가 모두 운영체제를 이용하게 될 때(경쟁 상황일 때)
역할의 범위가 동등하여 운영체제의 부담이 커지게 된다. 

이러한 운영체제의 부담을 줄이기 위해서 비대칭 시스템이 있는데 비대칭 시스템은 마스터-슬레이브 관계가 되어
마스터인 경우에만 운영체제를 사용할 수 있게 되어 운영체제의 구현이 간단해지는 장점이 있다.
하지만 마스터가 고장나면 대책이 없다.
```

### 4. 분산 처리 시스템의 일종인 강결합 시스템(시스템 버스, 메모리 등이용)
```
1. 단일 공유 버스 : CPU들이(처리기들)이 하나의 버스를 공유하여 메모리에 접근하므로 경쟁 구도, 배타적인 성향을 띠며
CPU를 추가해도 성능은 갈 수록 저하된다. 어느 순간 없는게 더 나을 수도 있다.

2. 다중 버스 : CPU가 여러 개의 버스를 공유한다. 1:1 느낌 하지만 모든 버스가 사용중이면 기다려야 한다.

3. 크로스바 스위치 버스 : 교차 지점에 스위치를 갖다두어 물리적인 버스의 수를 줄였다.

4. 계층적 버스 : 로컬 버스(Local Bus와 시스템버스(Global bus)로 나누고 전용 메모리 처리기를 로컬 버스에 두고
커버가 안되는 메모리를 컴파일러가 배분하고 배치하게 된다

5. 다중 포트 메모리 : 예로 CPU -> VRAM -> GPU 를 들 수 있다. VRAM은 포트가 두개로 CPU와 GPU와의 버스 경쟁 없이
VRAM의 내용을 읽어서 모니터에 디스플레이할 수 있는 장점이 있다.
```

### 분산 처리 시스템(Distributed Computing Systems)
```
분산 처리 시스템은 독립된 시스템들이 버스가 아닌 네트워크로 연결되어 병렬 처리 환경을 제공한다.
분산 처리 시스템의 목적 및 효과로서 성능향상, 자원공유, 신뢰성 향상, 점진적 확장 등을 들 수 있다.
분산 처리 시스템은 위치 투명성, 접근 투명성, 고장 투명성, 중복 및 이동 투명성 등의 기능이 제공되어야 한다.
(어디 있는 지,중복인지, 이동이 되었는 지, 고장이 났는 지를 사용자는 그 내용을 인식할 필요가 없다는 뜻)
분산 처리 시스템은 네트워크로 연결되므로, 버스로 연결되는 강결합 시스템에 대비되는 개념으로
약결합 시스템 혹은 클러스터 시스템이라고 부른다.
분산 처리 시스템의 연결 형태에는 하이퍼 큐브, 완전 연결, 성형, 링형 등이 있다.
```

### 분산 처리 시스템의 연결 형태
```
1. 하이퍼 큐브 : 노드 간의 평균 거리가 짧고 경로 배정이 비교적 간단하다. 노드 하나의 연결된 노드 수를 n이라고 할 때 총 노드의 수는
2의 n승이 된다.

2. 완전 연결 : 모든 노드들이 직접 1:1 통신을 할 수 있도록 연결한 연결 형태이다. 사이트 간 통신 속도가 빠르고 연결 경로가 많아
통신 신뢰성이 높다는 장점이 있다. 하지만 초기 설치 비용과 확장 비용이 크다.

3. 성형 : 중앙에 중계 시스템을 두는 형태로 초기 설치, 확장이 쉽지만 중개 역할이 고장나면 안되서 신뢰성이 낮다.

4. 링형 : 성형 연결의 단점과 장점을 절충한 형태로 연결 반경이 좁고 새로운 노드 추가가 용히하나 두 개 이상의 노드가 다운되면 전체
네트워크가 양분된다.
```

## 컴퓨터의 주요 구성 요소
```
컴퓨터의 주요 구성 요소는 시스템 버스, 즉 어드레스 버스, 데이터 버스, 제어 버스 등 3 종류의 버스로 연결되어 있다.
```

## 주기억 장치(Main Memory)
```
주기억장치는 비트(Bit) 8개의 묶음으로 이루어진 바이트(byte) 단위로 주소가 배정된다.
읽기 쓰기는 바이트 단위의 배수로 가능한데, 어떤 CPU는 한꺼번에 접근하려는 바이트들의 시작주소가 특정 조건을 
만족하도록 하는 메모리 얼라이먼트(Memory Alignment)를 요구하기도 한다.
```

## 기계 명령어(Machine Instruction)
```
기계 명령어(Machine Instruction)은 연산코드(Operation code)와 피연산자(Operand)로 구성되고, 연산코드 부분의
크기는 연산 종류의 개수를, 피연산자 부분의 크기는 최대 메모리 용량을 결정한다.

피연산자는 연산코드에 따라 주소, 상수, 레지스터 번호 등 다양하게 해석된다.
```

## 기계 사이클(Machine Cycle)
```
기계 사이클은 CPU가 반복적으로 처리하는 동작의 패턴으로서, 명령어 인출(Fetch), 명령어 해석(Decode),
피연산자 인출(Operand), 연산 처리(Execution) 주기 등 크게 4개의 주 스텝으로 구성된다.
하나의 명령어 연산이 완료되면 CPU는 자동적으로 PC 레지스터가 가르키는 다음 명령어 처리를 개시한다.
```

## 레지스터(Register)
```
레지스터(Register)란 소량의 데이터를 특별한 용도로 저장하는 곳으로, 크게 CPU 레지스터와 특수 레지스터(SFR),
입-출력 레지스터로 분류된다.

CPU 레지스터는 주로 연산을 위한 피연산자의 임시 저장 용도로, 특수 목적 레지스터는 컴퓨터의 상태 설정 등 특수 용도로,
그리고 입 출력 레지스터는 주변 장치와의 입 출력 창구 용도로 사용된다.
```

## 주소 지정 모드(Addressing mode)
```
주소 지정 모드는 피연산자를 해석할 수 있는 유형을 말하고, 직접(Direct), 간접(Indirect), 절대(Absolute)
상대(Relative), 주소(Address), 상수(Constant) 관점에서 분류된다.
```

## 인터럽트(Interrupt)
```
인터럽트가 발생하면 CPU는 처리 중이던 명령어 순서를 보관한 후, 사전에 설정된 주소로 점프하여 새로운 처리를 시작하게 되는데,
이 부분을 인터럽트 서비스 루틴(ISR: Interrupt Service Routine) 혹은 인터럽트 핸들러(Interrupt Handler)라 부른다.
```

## 인터럽트 벡터(Interrupt Vector)
```
인터럽트들은 고유의 번호에 의해 식별되고, 이들 인터럽트들에 대응되는 인터럽트 핸들러들의 주소가 표 형태로 기록된
부분을 인터럽트 벡터(Interrupt Vector)라 한다.

인터럽트 벡터는 CPU에 따라 고정된 경우와 설정 가능한 경우가 있고, 그 크기는 보통 수십 ~ 수백 개 정도의 인터럽트를 
지원할 수 있다.
```

## 인터럽트 우선순위(Interrupt Priority)
```
여러 개의 인터럽트가 동시에 발생하거나, 인터럽트 핸들러 처리 도중 다른 인터럽트가 발생하면 CPU 우선순위에 따라
처리 순서를 결정한다.
```

## 인터럽트 사이클(Interrupt Cycle)
```
CPU는 기계 사이클 마지막 주기인 인터럽트 사이클(Interrupt Cycle)에서 인터럽트 발생을 조사한다.
```

## 인터럽트 유형 
```
1. 디바이스 인터럽트 : 입출력 장치 등과 같이 CPU 외부 하드웨어로 부터 발생하고 대부분의 인터럽트가 여기에 해당된다.
2. 오류 인터럽트 : 0으로 나누는 등의 연산 불가 상황에서 오류 인터럽트 루틴에 가서 대응한다.
3. 소프트웨어 인터럽트 : 기계 명령어에 의해 프로그램에서 인위적으로 발생되는 인터럽트를 소프트웨어 인터럽트라 하고 
트랩이라고 부르기도 한다.
```

## 이중 모드 연산(Dual Mode Operation)
```
사용자 모드(사용자 프로그램 실행 모드)와 시스템 모드(운영체제 실행 모드)가 식별되는 경우를 이중 모드 연산
(Dual Mode Operation)이라 하고, 시스템 모드에서만 실행 가능한 기계 명령어를 특권 명령어(Privileged Instruction)라 한다.
```

## 입출력 장치
```
장치 구동기(IO Device Driver) : 상태, 명령, 데이터 레지스터, 키보드

상태 레지스터 : 입력 장치인 경우 입력되어있는 가의 여부 표시, 출력 장치인 경우 이전 데이터의 출력이 완료 되었는가를 표시
 
명령 레지스터 : 입력 혹은 출력의 기본 명령과 기타 해당 장치 고유의 명령을 저장함으로써 명령을 전달한다.

비동기적 입력(키보드 등) : 언제 들어올 지 모르는 명령을 처리
동기적 입력(디스크 등) : 입력 명령에 따라 입력

출력은 언제나 동기적

데이터 레지스터 : 입력된 데이터나 출력될 데이터를 보관한다.
```

## 입출력 장치의 식별
```
CPU에서 메모리에 접근하는 것(주소 공간을 식별

식별 방법

1. 메모리 대응 입출력 : 레지스터 이름 -> 입출력 포트 번호(수치)
메모리 접근 명령와 동일한 기계 명령어(load, save)를 사용하여 입출력을 진행함

2. 격리된 입출력 : 메모리 주소 공간과 입출력 포트공간이 같을 때는
입출력 레지스터가 주기억 장치 영역과 완전히 분리되어
다른 기계 명령어(in, out)을 사용하여 입출력을 진행함
```

## 컴퓨터 저장장치
```
레지스터 : 

캐시 : CPU -> Memory의 데이터를 복사해두어서 다음에 같은 데이터를 가져올 때는 캐시메모리에서 가져온다.
캐시 메모리는 비싸서 10% 차지 캐시가 다 차면 오래된 데이터를 비우고 새로운 데이터를 넣는다.적으로 일반적으로는 캐시는 cpu와 주기억장치 사이에서 주기억장츼를 돕는 저장장치를 말한다.

주기억장치 : DRAM (Dynamic Random Access Memory): 일정 시간 지나면 저장되어 있는 것이 점점 사라짐 주기적으로 읽어줘야 해서 속도의 제한이 걸린다. 직접도를 더 높일 수 있어서 사용함..... 속도가 느리고

SRAM (Static Random Access Memory) : Refresh가 필요없고 전원이 공급되는 한 저장값이 안정적으로 유지된다. 속도가 빠르다.

전자 디스크 : SSD(Solid State Disk) : 하드디스크와 DRAM의 장점을 갖춘 플래시 메모리 기술 기반의 디스크 

자기 디스크 :

광 디스크 :

자기 테이프
```

## 직접 입 출력 & 간접 입 출력
```
직접 입출력 : 운영체제가 응용프로그램과 하드웨어 사이에서 데이터를 가공없이 그대로 전달

간접 입출력 : 운영체제가 응용프로그램과 하드웨어 사이에서 데이터를 가공해서 전달(대부분)

문자단위 입출력 : 바이트 단위 입출력(키보드, LAN 등),

블록 입출력 : 디스크의 512바이트 단위 입출력과 같이 일정한 크기의 블록 단위 입출력
```

## 프로그램 입/출력
```
한 번에 이루어 질 수 있는 입출력량은 주변장치에 따라 다르나, 일반적으로 단말기와 같이 1바이트 단위로
이루어지는 경우를 문자 입출력 장치, 하드 디스크와 같이 수십~수백바이트 단위로 이루어지는 경우를 
블록 입출력 장치라고 함
```

## 프로그램 입출력 혹은 바쁜 대기 입출력(Programmed I/O or Busy Waiting I/O)
```
운영체제(CPU)가 입출력 상태 레지스터 값을 지속적으로 읽어서 입 출력의 진행 완료 유휴 등의
상태를 확인하여 완료나 유휴 상태가 되면 입출력을 진행
```

## 인터럽트 기반 입출력(Interrupt-driven I/O)
```
운영체제는 입출력 명령 레지스터에 입출력 명령을 기록한 후 다른 사용자 프로그램으로 점프함으로써
입출력이 진행되는 동안 CPU는 다른 일을 수행. 입출력이 완료되어 CPU에게 인터럽트가 전달되면
CPU는 해당 인터럽트 핸들러에서 다음 입출력을 진행한 다음, 수행 중이던 원래 사용자 프로그램으로 복귀
```

## DMA 입 출력(DMA I/O) 
```
운영체제는 입력 버퍼나 출력 데이터의 주소, 입출력 데이터 크기, 입력 혹은 출력 명령 등 세 가지를 DMA 처리기에
설정하고 다른 사용자 프로그램으로 점프. DMA는 CPU 대신 인터럽트 기반으로 입출력을 진행하고, 전체 입출력이
완료되면 CPU에 완료 인터럽트를 전달
```

## 입출력 채널
```
여러 개의 입 출력 장치를 관장하여 입출력을 처리하는 처리기를 입출력 채널이라고 하고,
실렉터 채널, 멀티플렉서 채널, 블록 멀티플렉서 채널 등 세 가지 유형이 있음
(DMA는 하나의 장치만 관리할 수 있는 단순 입출력 채널이라고 보면 됨)

실렉터 채널(Selector Channel)은 입출력 명령을 하나씩 받아 처리, 즉 여러 장치에 대한 동시 입출력을 하지 않는데, 
그 이유는 입출력 장치들의 속도가 디스크와 같이 고속이기 때문임

멀티플렉서 채널(Multiplexor Channel)은 입출력 명령을 여러 개 받아서 동시 진행 가능 
장치들이 키보드, 프린터 등과 같이 저속인 경우에만 가능

블록 멀티플렉서 채널(Block Multiplexor Channel)은 여러 개의 입출력 명령으로 구성된 명령어 집합(Block)을 받아 
자동으로 차례차례 처리. 실렉터 채널과 멀티플렉서 채널 양쪽의 특성을 모두 가짐)
```

## 프로세스의 정의
```
프로세스 : 프로그래밍 언어로 작성된 후, 운영체제의 도움으로 주기억장치에 적재되어 실행중인프로그램
```

## 운영체제가 관리하는 프로세스 속성들
```
프로세스 고유번호(PID), 프로세스 메모리 정보, 프로세스 상태, 프로세스 진행지점,
프로세스 문맥, 프로세스 우선순위, 프로세스 자원목록, 회계정보 등

프로세스 문맥(Process Context) :  현재 진행중인 프로세스의 연산 명령어들에 의해
CPU 안에서 생산되어 보관 중인 값들을 프로세스 문맥이라고 한다.

문맥은 CPU가 진행 중이던 프로세스를 떠날 때 보관되었다가 나중에 처리를 재개하기 직전에
복원되어야 한다. 이를 문맥 교환이라고 한다.
```

## 프로세스 관리 블록
```
프로세스가 운영체제에 의해 하나의 관리 개체로 등록됨을 의미한다. 
운영체제가 프로세스 관리를 위해 필요한 모든 정보를 기록하는 표를 PCB라고 하는데, 
그 수는 곧 생성 가능한 최대 프로세스 수를 의미한다. 
PCB는 주로 위에서 언급한 전형적인 프로세스 속성들이 저장된다.
```

## 프로세스 상태 (상태 천이)
```
운영체제는 프로세스의 처리과정에서 프로세스의 활동에 따라 해당 프로세스를 적절한 상태로 천이 시킨다.
실행 상태가 아닌 모든 프로세스는 해당 상태의 대기열에 관리된다.

프로세스 상태
준비 상태
실행 상태 dispatch : CPU를 어디에 할당할 지 배정하는 행위 
대기 상태 Block State CPU 입출력을 기다리는
보류 상태 CPU 배정 대상에서 제외, 시간을 기다리는 
대기-보류 상태 큐(대기열) FIFO 큐의 개념 1순위 대기 상태에서 너무 오래 있으면 보류 상태로 만든다.
종료 상태 : 완료 요청을 받고 제거 준비로 메모리에 남아있는 상태를 좀비(Zombie)라고 한다.
```

## 스레드 (Thread)
```
프로그램이 실행되는 흐름 줄기
보통 프로세스는 하나의 실행 줄기, 즉 하나의 스레드를 가짐(단일 스레드 프로세스)
```

## 다중 스레드 프로세스(Multi-thread Process)
```
운영체제의 요청으로 스레드가 여러 개가 있을 수 있다.
CPU가 반드시 여러 개일 필요는 없음
CPU가 하나이거나 여러 개일 경우에는 스레드를 병렬 처리됨

1+2+3+4 하려고 했는데 1+2 를 하나의 스레드로 3+4를 하나의 스레드로 나눠서 한다.
스레드가 각각 독립적으로 실행된다.(cpu가 하나씩 붙어서) -> 병렬 처리 (처리 시간을 단축시킬 수 있음)
CPU가 각자 기계 사이클을 실행한다.
```

## 스레드 생성 및 제거
```
운영체제에게 스레드 생성을 요청할 수 있다. pthread_create(스레드할 함수)
pthread_exit() 해당 스레드를 소멸 자동 변수는 참조하는 메모리를 별도로 분리해서 얽히지않지만
전역변수에 여러 스레드가 접근할 때는 경쟁 상황이 발생한다.
thread_join 스레드가 종료될 때까지 기다림 
```
## 새로운 프로세스 생성과 제거
```
새로운 프로세서(Child)의 생성은 이미 생성되어 실행 중인 다른 프로세서(Parent 프로세서)가 운영체제에게 요청함으로써 이루어진다.
정상적인 프로세서 제거는 해당 프로세스 스스로가 운영체제에 요청함으로써 이루어짐

fork 부모는 fork > 0 자식은 fork = 0 if(fork = 0)이라면 새로운 프로그램을 적재하면 프로그램을 덮어쓰게 됨
```

## 4장 프로세스 및 스레드 관리 과제

### prog_04_10.c
![image](https://user-images.githubusercontent.com/58906858/230433497-18a1bf3f-660f-42e9-9a80-75fde3e9adcf.png)

### prog_04_11.c
![image](https://user-images.githubusercontent.com/58906858/230434198-f40abb34-dad9-4f7b-b2f5-59681d63909e.png)

## 프로세스 간 통신(Inter-Process Communication : IPC)
```
프로세스들은 완전히 분리 독립되어 있어서 서로 간에 간섭하거나 정보를 주고 받을 수 없다.
거대한 프로그램을 여러 개의 작은 프로그램으로 분리할 경우, 이들 사이에는 통신할 수 있는 수단이
필요하게 되는데,이를 프로세스 간 통신(IPC, Inter-Process Communication)이라 부른다.
IPC의 대표적인 예로, 파이프, 메시지 큐, 공유 메모리, 세마포, 소켓 등을 들 수 있다.
```
## 프로세스 통제(Process Control)
```
운영체제는 사용자에게 실행 중인 프로그램을 통제할 수 있는 수단을 제공한다.
프로세스 통제의 전형적인 유형으로 강제 종료, 일시 중지, 실행 재개, 약속 처리, 우선순위 변경 등을 
들 수 있다.
유닉스 리눅스에서는 프로세스 통제를 위해 kill() 시스템 콜과 kill 명령어를 제공한다.
```
## 단계별 처리 스케줄링
```
장기 스케줄링 : 대기 중인 프로그램들 중, 먼저 시작시킬 프로세스를 선택
중기 스케줄링 : 적재된 프로세스들 중, 처리를 잠시 보류할 프로세스를 선택
단기 스케줄링 : 준비 상태의 프로세스들 중, CPU를 먼저 할당할 프로세스를 선택
```
## CPU 스케줄링 전략의 목표 및 기준
```
사용자 관점에서의 CPU 스케줄링 목표 지표
응답 시간(Response Time) : 사용자 데이터 입력 후, 출력이 이루어질 때까지의 소요 시간
반환 시간(Turnaround Time) : 프로그램 제출(혹은 시작) 후, 끝날 때까지 소요되는 총 시간
대기 시간(Waiting Time) : 프로세스들이 준비 상태로 대기열에서 기다린 시간의 총합

시스템 관점에서의 CPU 스케줄링 목표 지표
CPU 이용률(CPU Utilization) : 총 경과 시간 대비 CPU가 순수하게 사용자 프로세스를 수행한 시간의 비
처리율(Throughput) : 단위 시간당 처리된 프로세스의 개수

사용자 관점과 시스템 관점의 CPU 스케줄링 목표 지표는 상호 배타적 관계에 있는 경우가 일반적임
```
