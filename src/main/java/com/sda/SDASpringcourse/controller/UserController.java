package com.sda.SDASpringcourse.controller;

import com.sda.SDASpringcourse.model.CreationStatus;
import com.sda.SDASpringcourse.model.CreationStatusFactory;
import com.sda.SDASpringcourse.model.News;
import com.sda.SDASpringcourse.model.User;
import com.sda.SDASpringcourse.repository.JpaNewsRepository;
import com.sda.SDASpringcourse.repository.JpaUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(path = "/users") //to bedzie doklejone z przodku kazdej path przy endpoincie
public class UserController {

    @Autowired
    private JpaUserRepository userRepository;

    @Autowired
    private JpaNewsRepository newsRepository;

    @Autowired
    CreationStatusFactory creationStatusFactory;

    //1 - wyswietlenie usera o zadanym id (id pochodzi z listy userow z mocka)
    //usuniety, zostal napisany od nowa w endpoincie 4


    //2 - wyswietlenie wszystkich userow

    @GetMapping //dla sciezki "/users"
    public ModelAndView allUsers() {
        ModelAndView modelAndView = new ModelAndView("users");

        Iterable<User> all = userRepository.findAll();

        modelAndView.addObject("allUsers", all);

        return modelAndView;
    }

    //3 - wyswietlenie wszystkich userow o nazwisku rozpoczynajacym sie od przekazanego parametru

    @GetMapping(params = {"lastname"}) //dla sciezki "/users?lastname=cokolwiek"
    public ModelAndView allUsersByLastName(@RequestParam(value = "lastname") String lastname) {
        ModelAndView modelAndView = new ModelAndView("users");

        List<User> allByLastName = userRepository.findByLastName(lastname);

        modelAndView.addObject("allUsers", allByLastName);

        return modelAndView;
    }

    //4 - wyswietlenie usera o zadanym id (id pochodzi z bazy) - analogiczne do pierwszego

    @GetMapping(value = "/{userId}") //dla sciezki "/users/{userId}"
    public ModelAndView specifiedUser(@PathVariable("userId") Integer userId) {
        ModelAndView modelAndView = new ModelAndView("user");

        User user = userRepository.findOne(userId);

        List<News> userNewsList = newsRepository.findByUser(user);

        modelAndView.addObject("user", user);
        modelAndView.addObject("allNews", userNewsList);

        return modelAndView;
    }

    //5 - dodawanie nowego newsa z poziomu strony danego usera (metoda POST)

    @PostMapping(value = "/{userId}") //dla sciezki "/users/{userId}"
    public ModelAndView addNewsForUser(@ModelAttribute News news, @PathVariable("userId") Integer userId) { //adnotacja @ModelAttribute powoduje, ze
        // Spring bedzie probowal przerobic to co przychodzi z formularza na gotowy obiekt typu News !!!

        ModelAndView modelAndView = new ModelAndView("user");

        User user = userRepository.findOne(userId);

        //newsowi, ktory przyszedl w argumencie metody nie trzeba ustawiac wlasciciela, bo spring jest madry i na podstawie id,
        // ktore przyjdzie z hidden input z formularza sam pobierze sobie odpowiedniego usera
        //a nastepnie calosc informacji z formularza jest w locie, przez springa przerabiana na obiekt typu News,
        //ktory jest juz dostepny w tej metodzie (dzieje sie to dzieki adnotacji @ModelAttribute)
        newsRepository.save(news);
        boolean result = true; //celowo, bo w tej chwili nie wiem jak sprawdzic, czy zapis sie powiodl

        List<News> userNewsList = newsRepository.findByUser(user);

        CreationStatus status =
                result ? creationStatusFactory.createSuccessStatus("Poprawnie dodano nowy news...")
                        : creationStatusFactory.createFailureStatus("Wystąpił błąd podczas zapisywania newsa...");

        modelAndView.addObject("status", status);
        modelAndView.addObject("user", user);
        modelAndView.addObject("allNews", userNewsList);

        return modelAndView;
    }

    //6 - dodawanie nowego usera z poziomu strony z lista wszystkich userow (metoda POST)

    @PostMapping //dla sciezki "/users", tak jak w endpoincie 2
    public ModelAndView addNewUser(@ModelAttribute User user) {
        ModelAndView modelAndView = new ModelAndView("users");

        userRepository.save(user);
        boolean result = true;

        CreationStatus status =
                result ? creationStatusFactory.createSuccessStatus("Poprawnie dodano nowego usera...")
                        : creationStatusFactory.createFailureStatus("Wystąpił błąd podczas zapisywania nowego usera...");

        Iterable<User> all = userRepository.findAll();

        modelAndView.addObject("status", status);
        modelAndView.addObject("allUsers", all);

        return modelAndView;
    }

}
