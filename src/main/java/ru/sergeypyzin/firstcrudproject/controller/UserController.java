package ru.sergeypyzin.firstcrudproject.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.sergeypyzin.firstcrudproject.model.User;
import ru.sergeypyzin.firstcrudproject.service.UserService;


import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public String findAll(Model model){
        List<User> users = userService.findAll();

        model.addAttribute("users", users);
        return "user-list";
        //return "home.html";
    }

    @GetMapping("/user-create")
    public String createUserForm(User user){
        return "user-create";
    }

    @PostMapping("/user-create")
    public String createUser(User user){
        userService.saveUser(user);
        return "redirect:/users";
    }

    /**
     * Обрабатывает запрос на удаление пользователя по его идентификатору.
     * После удаления пользователя перенаправляет на страницу списка пользователей.
     *
     * @param id идентификатор пользователя, которого нужно удалить
     * @return строка для перенаправления на страницу списка пользователей
     */
    @GetMapping("user-delete/{id}")
    public String deletedUser(@PathVariable("id") int id){

        // Обработка запроса на удаление пользователя по его идентификатору id
        userService.deleteById(id);

        // Перенаправление на страницу списка пользователей
        return "redirect:/users";
    }

    /**
     * Отображает форму для обновления информации о пользователе с указанным идентификатором.
     *
     * @param id    идентификатор пользователя, информацию о котором нужно обновить
     * @param model модель для передачи данных на страницу
     * @return имя представления для страницы обновления информации о пользователе
     */
    @GetMapping("/user-update/{id}")
    public String updateUserForm(@PathVariable("id") int id, Model model) {

        // Получение информации о пользователе по его идентификатору
        User user = userService.getOne(id);

        // Передача информации о пользователе на страницу через модель
        model.addAttribute("user", user);

        // Возврат имени представления для страницы обновления информации о пользователе
        return "user-update";
    }

    /**
     * Обрабатывает запрос на обновление информации о пользователе.
     * После обновления информации о пользователе перенаправляет на страницу списка пользователей.
     *
     * @param user объект пользователя с обновленными данными
     * @return строка для перенаправления на страницу списка пользователей
     */
    @PostMapping("/user-update")
    public String updateUser(User user) {

        // Обновление информации о пользователе
        userService.update(user);

        // Перенаправление на страницу списка пользователей
        return "redirect:/users";
    }


}
