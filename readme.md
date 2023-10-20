Autor: Konrad Laskowski

# Jaskinie

Witam w aplikacji służącej do  znajdowania optymalnych ścieżek pomiędzy jaskiniami.

# Opis

Użytkownik może dostarczyć własne dane na temat jaskiń i ich połączeń, a następnie otrzymać wynikową najbardziej optymalną ścieżkę eksploracji.

# Funkcje

- Wczytywanie danych o jaskiniach z pliku "CAV.IN".
- Wyszukiwanie optymalnej ścieżki eksploracji jaskiń.
- Zapisywanie wynikowej ścieżki eksploracji do pliku "CAV.OUT".


# Dane wejściowe:

Aplikacja wczytuje dane z pliku o nazwie CAV.IN znajdującego się w folderze data.

Format pliku wejściowego:
Pierwsza linia: Zawiera dwie liczby całkowite n i k oddzielone pojedynczą spacją.

n (3 < n ≤ 500) to całkowita liczba komnat w jaskini.
k (k ≤ 3) to liczba komnat zewnętrznych.
Komnaty są ponumerowane od 1 do n, przy czym komnata wejściowa ma zawsze numer 1. Komnaty zewnętrzne mają numery od 1 do k. Choć są one numerowane od 1 do k, niekoniecznie muszą być rozmieszczone na obwodzie jaskini w tej kolejności.

Kolejne 3n/2 linii: Każda z tych linii opisuje korytarz między dwoma komnatami.

Każda linia składa się z trzech liczb całkowitych: a, b i c, oddzielonych pojedynczymi spacjami.
a i b to numery komnat połączonych tym korytarzem.
c może przyjmować wartość 0 lub 1.
0 oznacza, że korytarz jest łatwy.
1 oznacza, że korytarz jest trudny.

Przykład:
```
8 5       --> 8 komnat w tym 5 zewnetrznych \n
1 3 0     --> korytarz z komnaty 1 do 3 jest łatwy (0) \n
3 2 0
7 3 1     --> korytarz z komnaty 7 do 3 jest trudny(1)
7 2 0         itd.
8 7 0
1 8 0
6 8 0
6 4 0
6 5 1
5 4 0
2 4 0
5 1 0

```


# Dane wyjściowe:
Ciąg n liczb całkowitych oddzielonych pojedynczymi spacjami.
Pierwsza liczba to zawsze 1, reprezentująca numer komnaty wejściowej.
Kolejne n-1 liczb to numery kolejnych komnat trasy zwiedzania.

Przykład:
```
1 5 4 6 8 7 2 3
```
W powyższym przykładzie:

Komnata wejściowa ma numer 1.

Ścieżka zwiedzania prowadzi przez komnaty w kolejności: 1, 5, 4, 6, 8, 7, 2, 3.

Powyższa ścieżka jest jednym z możliwych poprawnych wyników, które spełniają warunki problemu.



# Wymagania:

- Java JDK 17 lub nowsza.
- Maven (zalecana wersja 3.x).

# Instalacja i uruchomienie:


1. Sklonuj repozytorium:
  
   `git clone`

2. Przejdź do folderu projektu:

   `cd my-app`


3. Skompiluj i zbuduj projekt:
   
   `mvn clean install`
   

4. Uruchom aplikację:
   
   `mvn exec:java`

# Testy:

Aby uruchomić testy, użyj poniższego polecenia w katalogu głównym projektu:

   `mvn test`
