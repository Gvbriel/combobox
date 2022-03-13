
Napisać aplikację webową, która będzie pobierała dane z zewnętrznej bazy
danych. Na pierwszej stronie użytkownik wybiera z rozwijalnej listy
nazwę kolumny z zewnętrznej bazy danych (lista może być na stałe zaszyta w stronie). Po zaakceptowaniu wyboru przyciskiem należy wykonać zapytanie do bazy
danych. Powinno ono zwracać te krotki (z wszystkimi kolumnami), dla których wartości w wybranej w formularzu kolumny powtarzają się (pkt.2) lub są unikalne (pkt.3). Poszczególne krotki powinny w wynikach występować tylko raz. Po otrzymaniu wyniku dane należy przedstawić na kolejnej (lub na tej samej np. w technologii AJAX bez przeładowania strony) stronie w postaci tabeli.

Ponieważ zadanie jest dość rozbudowane i dotyka różnych technologii można je podzielić na kilka etapów ocenianych odrębnie:
1. Stworzenie strony www umożliwiającej wybór z Combobox'a kolumny i przekazanie zapytania na stronę serwera (który ma dostęp do bazy danych)
2. Stworzenie zapytania SQL, do bazy danych (najlepiej postgreSQL) zwracającego powtarzające się krotki dla wskazanej kolumny (tzn. takie dla których wybrana kolumna ma kilka takich samych wartości).
Przykład:
Dla załączonej bazy danych i dla podanej kolumny: kolumna1   	Pożądany wynik zapytania: 
4;"wartość54";"wartość43";"wartość45";4 5;"wartość43";"wartość23";"wartość34";4 6;"wartość43";"wartość54";"wartość43";2 7;"wartość54";"wartość52";"wartość53";8 9;"wartość43";"wartość33";"wartość45";9
3. Stworzenie zapytania SQL, do bazy danych (najlepiej postgreSQL) zwracającego unikalne wiersze 
Przykład:
	Dla załączonej bazy danych i dla podanej kolumny: kolumna1   	Pożądany wynik zapytania:
		1;"wartość1";"wartość2";"wartość3";1 		2;"warość21";"wartość22";"wartość23";5 		3;"wartość31";"wartość22";"wartość32";6 		8;"wartość21";"wartość2211";"wartość43";4 		10;"wartość87";"wartość62";"wartość11";3
4. Wyświetlenie rezultatów zapytania na stronie WWW
5. Wyświetlenie rezultatów ze strony bez przeładowania strony (np. technologia AJAX)

Zalecane technologie: Java (8+), Lombok, Maven, Spring Boot, Spring Data, Hibernate, JPA, JSP, baza danych dowolna (preferowana Postgres).

Dodatkowym atutem będzie wykorzystanie technologii: Docker, Vue, SASS/SCSS/LESS, Node/NPM/Yarn, Webpack, Axios.