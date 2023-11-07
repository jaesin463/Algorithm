# [Gold I] Smok - 7948 

[문제 링크](https://www.acmicpc.net/problem/7948) 

### 성능 요약

메모리: 16792 KB, 시간: 320 ms

### 분류

그리디 알고리즘, 정렬

### 제출 일자

2023년 11월 7일 10:43:08

### 문제 설명

<p>Ciężkie jest życie latającego smoka! Wydawałoby się, że nic prostszego – w długiej i głębokiej dolinie jest mnóstwo pastwisk ułożonych jedno za drugim. Na każdym z tych pastwisk jest pewna liczba owiec. Nic tylko ucztować nieustannie, lecz kodeks honorowy smoków pozwala na tylko jedną ucztę dziennie polegającą na pożarciu wszystkich owiec z jednego pastwiska.</p>

<p>Smok ma również inne problemy. Jeżeli przeleci nad jakimś pastwiskiem, to wszystkie owce uciekają w popłochu i już więcej się na nim nie pojawiają. Ponadto zbocza doliny są tak wysokie, że nawet smok nie jest w stanie nad nimi przelecieć. Musi on zatem lecieć wzdłuż doliny (może wybierać z której strony doliny przyleci danego dnia) i jeżeli zje owce z pastwiska x to wszystkie owce z pastwisk nad którymi przelatuje (1 . . . x − 1 albo x + 1 . . . n) przepadają bez wieści.</p>

<p>Jest też drugi problem – pod koniec każdego dnia na każdym pastwisku stan owiec zmniejsza się o 1 w wyniku różnych przyczyn (wilki, choroby, ucieczki, pogłoski o latających smokach w okolicy). Z tego powodu smok ma nie lada dylemat – czy bardziej opłaca się napadać na pastwiska po kolei i patrzeć jak z najliczniejszych pastwisk znikają owce, czy też zacząć od tych największych, ale płosząc po drodze wiele mniejszych.</p>

<p>W końcu smok postanowił rozwiązać problem w sposób nowoczesny i zamówił u Ciebie program.</p>

### 입력 

 <p>Pierwsza linia wejścia zawiera małą liczbę całkowitą z – liczbę zestawów danych występujących kolejno po sobie. Opis jednego zestawu jest następujący:</p>

<p>Składa się on z jednego wiersza. Na początku wiersza występuje jedna liczba całkowita k będąca liczbą pastwisk (1 ≤ k ≤ 10000). Po niej następuje k liczb całkowitych oddzielonych spacjami (z przedziału [0 . . . 100000]) odpowiadających liczbie owiec na kolejnych pastwiskach.</p>

### 출력 

 <p>Dla każdego zestawu danych wypisz jedną liczbę – maksymalną liczbę owiec, które może zjeść smok.</p>

