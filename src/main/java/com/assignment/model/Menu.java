package com.assignment.model;
import java.util.List;



public class Menu {
    private String id;
    private String value;
    private Popup popup;

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Popup getPopup() {
        return popup;
    }

    public void setPopup(Popup popup) {
        this.popup = popup;
    }

    public static class Popup {
        private List<MenuItem> menuitem;

       
        public List<MenuItem> getMenuitem() {
            return menuitem;
        }

        public void setMenuitem(List<MenuItem> menuitem) {
            this.menuitem = menuitem;
        }

        public static class MenuItem {
            private String value;
            private String onclick;

            
            public String getValue() {
                return value;
            }

            public void setValue(String value) {
                this.value = value;
            }

            public String getOnclick() {
                return onclick;
            }

            public void setOnclick(String onclick) {
                this.onclick = onclick;
            }
        }
    }
}
