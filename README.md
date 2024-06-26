# Проект "firstCRUDProject"

Этот проект представляет собой простое веб-приложение для выполнения операций CRUD (Create, Read, Update, Delete) с пользователями.

## Описание

Приложение разработано с использованием Java и Spring Boot. Оно позволяет выполнять следующие операции:

- Просмотр списка пользователей
- Создание нового пользователя
- Удаление пользователя
- Обновление информации о пользователе

## Структура проекта

Проект содержит следующие основные пакеты и классы:

- `ru.sergeypyzin.firstcrudproject.model.User`: Класс, представляющий сущность "пользователь"
- `ru.sergeypyzin.firstcrudproject.controller.UserController`: Контроллер для обработки HTTP-запросов, связанных с пользователями
- `ru.sergeypyzin.firstcrudproject.service.UserService`: Сервисный класс для выполнения бизнес-логики, связанной с пользователями
- `ru.sergeypyzin.firstcrudproject.repository.UserRepository`: Репозиторий для взаимодействия с базой данных пользователей

## Требования

Для запуска проекта требуется:

- Java 17
- Maven
- База данных H2 (встроенная база данных для упрощения)

