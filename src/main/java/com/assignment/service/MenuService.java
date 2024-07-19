package com.assignment.service;



import com.assignment.entity.MenuEntity;
import com.assignment.model.Menu;
import com.assignment.repository.MenuRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MenuService {

    @Autowired
    private MenuRepository menuRepository;

    private Menu predefinedMenu;

    public MenuService() {
        // Initialize predefined JSON model
        predefinedMenu = new Menu();
        predefinedMenu.setId("file");
        predefinedMenu.setValue("File");
        Menu.Popup popup = new Menu.Popup();
        Menu.Popup.MenuItem item1 = new Menu.Popup.MenuItem();
        item1.setValue("New");
        item1.setOnclick("CreateDoc()");
        Menu.Popup.MenuItem item2 = new Menu.Popup.MenuItem();
        item2.setValue("Open");
        item2.setOnclick("OpenDoc()");
        Menu.Popup.MenuItem item3 = new Menu.Popup.MenuItem();
        item3.setValue("Save");
        item3.setOnclick("SaveDoc()");
        popup.setMenuitem(List.of(item1, item2, item3));
        predefinedMenu.setPopup(popup);
    }

    public Menu manipulateMenu(String inputs) {
        String[] pairs = inputs.split(",");
        Map<String, String> replacements = new HashMap<>();
        for (String pair : pairs) {
            String[] keyValue = pair.split(":::");
            replacements.put(keyValue[0], keyValue[1]);
        }

        Menu manipulatedMenu = manipulateMenuModel(predefinedMenu, replacements);
        saveToDatabase(manipulatedMenu);
        return manipulatedMenu;
    }

    private Menu manipulateMenuModel(Menu menu, Map<String, String> replacements) {
        if (replacements.containsKey(menu.getValue())) {
            menu.setValue(replacements.get(menu.getValue()));
        }
        for (Menu.Popup.MenuItem item : menu.getPopup().getMenuitem()) {
            if (replacements.containsKey(item.getValue())) {
                item.setValue(replacements.get(item.getValue()));
            }
        }
        return menu;
    }

    private void saveToDatabase(Menu menu) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            String jsonModel = mapper.writeValueAsString(menu);
            MenuEntity entity = new MenuEntity();
            entity.setJsonModel(jsonModel);
            menuRepository.save(entity);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
