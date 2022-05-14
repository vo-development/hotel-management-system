# Hotel Management System

### Mysql ve JavaFX ile yazılmış bir otel yönetim uygulamasıdır

## Çalıştırmak için adımlar

**1. Projeyi klonlama**
```bash
git clone https://github.com/onurcantimur/javafx-mvc
```
**2. Docker ile veritabanı kurulumu**
***2.1 İlk Kurulum İçin:***
```bash
  docker-compose -f docker-compose.yml up -d
```
***2.2 Daha sonra tekrar kullanmak üzere kapatmak için:***
```bash
  docker stop db-mysql
```
***2.3 Kurulu olanı çalıştırmak için:***
```bash
  docker-compose start
```
***2.4 Containerları silmek için:***
```bash
  docker-compose down
```

**3. Uygulamayı çalıştırmak için:**
```bash
  mvn clean javafx:run
```


