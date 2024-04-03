package ru.sergeypyzin.firstcrudproject.service;


import org.springframework.stereotype.Service;
import ru.sergeypyzin.firstcrudproject.model.User;
import ru.sergeypyzin.firstcrudproject.repository.UserRepository;


import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User saveUser(User user){
        return userRepository.save(user);
    }

    /**
     * Удаляет пользователя из репозитория по его идентификатору.
     *
     * @param id идентификатор пользователя, которого нужно удалить
     */
    public void deleteById(int id) {
        userRepository.deleteById(id);
    }

    /**
     * Обновляет информацию о пользователе в репозитории.
     *
     * @param user объект пользователя с обновленными данными
     * @return обновленный объект пользователя
     */
    public User update(User user){
        return userRepository.updateUser(user);
    }

    /**
     * Возвращает информацию о пользователе из репозитория по его идентификатору.
     *
     * @param id идентификатор пользователя, информацию о котором нужно получить
     * @return объект пользователя с указанным идентификатором
     */
    public User getOne(int id) {
        return userRepository.findByID(id);
    }

}
