# DAO слой c Hibernate

## Запуск mysql базы данных с помощь образа docker, производится следующей командой:
`docker run -v /mysql_data:/var/lib/mysql -e MYSQL_ROOT_PASSWORD=mysql -p 3306:3306  mysql`

### Имя пользователя по умолчанию:  root
### Пароль мы передали при вводе команды: mysql (MYSQL_ROOT_PASSWORD=mysql )

 
***Далее определяем в application.properties параметр spring.jpa.hibernate.ddl-auto***.
 
**Варианты стратегий**:
* none - Hibernate не будет предпринимать никаких действий для управления базовой схемой базы данных.
* create-only - этот параметр предписывает Hibernate сгенерировать схему базы данных из  Entity.
* drop - этот параметр указывает Hibernate удалить схему.
* create - этот параметр предписывает Hibernate удалить схему базы данных и затем воссоздать ее, используя Entity.
* create-drop - этот параметр предписывает Hibernate удалить схему базы данных и затем воссоздать ее, используя Entity. После завершения работы приложения схема будет удалена.
* validate - этот параметр указывает Hibernate на необходимость проверки базовой схемы базы данных на соответствие сопоставлениям сущностей.
* update - этот параметр предписывает Hibernate обновить схему базы данных путем сравнения существующей схемы с сопоставлениями сущностей и создания соответствующих сценариев миграции схемы.



#### Проверяем методом-обработчиком GET-метода запроса с маппингом на endpoint /persons/by-city. В query params запроса приходит строковый параметр city, который передается дальше в репозиторий. То есть, метод обрабатывает звапрос типа:  localhost:8080/persons/by-city?city=Moscow. Контроллер должен будет возвращать всех людей, который он получит от репозитория.


### Ветка jpa-repository

* запуск приложения описан выше
* предварительно создадим в query console таблицу и добвавим записи, например:
  
CREATE TABLE persons
  (
  phone_number VARCHAR(255) NULL,
  city         VARCHAR(255) NULL,
  name         VARCHAR(255) NOT NULL,
  surname      VARCHAR(255) NOT NULL,
  age          INT          NOT NULL,
  CONSTRAINT pk_persons PRIMARY KEY (name, surname, age)
  );

insert into persons (age, name, surname, city, phone_number) VALUES (25,'Ivan','Kozlov','Moscow','232323');

insert into persons (age, name, surname, city, phone_number) VALUES (38,'Yuri','Petrov','Moscow','23445566');

insert into persons (age, name, surname, city, phone_number) VALUES (40,'Alex','Myrov','Saratov','234233566');

* Далее делаем запрос в браузере по endpoint установленным в контроллере(DataBaseController):

***Например:***

http://localhost:8080/persons/by-city?city=Saratov

http://localhost:8080/persons/by-age?age=40

http://localhost:8080/persons/by-name-surname?name=yuri&surname=Petrov

Ответ на запросы отображается в браузере в виде json объектов,например:

{"id":{"name":"Alex",

"surname":"Myrov",

"age":40},

"phone_number":"234233566",

"city":"Saratov"}]

### Ветка spring-security

* Вся логика прописана в конфигурационном классе SecurityConfig в пакете config, который помечен аннотацией @Configuration 
* По endpoint "/persons/by-city" доступ осущетсвляется без авторизации 
* По остальным endpoint по логину и паролю через стандартную форму авторизации(только для пользователей с ролями:"WHITE").
* чтобы разлогиниться вводим в адресной строке браузера http://localhost:8080/logout

### Ветка spring-security-oauth2

**Создан новый контроллер MyNewController в котором:**

* метод private String hello() возвращает значения только для пользователей с ролью "READ"(используйте @Secured)
* метод private String edit() возвращает значения только для пользователей с ролью "WRITE"(используйте @RolesAllowed)
* метод private String dataAccess() возвращает значения, если у пользователя есть хотя бы одна из ролей из "WRITE", "DELETE"(использована аннотация @PreAuthorize)
* метод public String myAccount(String username)  который принимает в качестве query параметра имя пользователя(username), и возвращает значения только если у пользователя username совпадает с именем пользователя в вашем объекте Authentication, 
который Spring security сохраняет в SecurityContextHolder после успешной аутентификации.