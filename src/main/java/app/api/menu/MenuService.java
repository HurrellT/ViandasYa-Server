package app.api.menu;

import app.model.Menu.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {

    //Parameters
    @Autowired
    private final MenuRepository menuRepository;

    //Constructor
    public MenuService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    //Methods
    public Menu addMenu(Menu menu) {
        return menuRepository.save(menu);
    }

    public Menu findMenuNamed(String name){ return  menuRepository.findByName(name); }

    public Menu findById(long id){ return menuRepository.findById(id).get(); }

    public List<Menu> getAllMenus() {
        return (List<Menu>) menuRepository.findAll();
    }
}
