package com.example.pt08_2072030.Controller;

import com.example.pt08_2072030.Dao.UserDao;
import com.example.pt08_2072030.Model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

public class UserController {
    @FXML
    private TextField txtUserName;
    @FXML
    private TextField txtPassword;
    public void submit(ActionEvent actionEvent) {
        UserDao dao = new UserDao();
        if (txtUserName.getText().isEmpty() || txtPassword.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Please fill the field", ButtonType.OK);
            alert.showAndWait();
        } else {
            User u = new User();
            u.setIdUser(0);
            u.setUserName(txtUserName.getText());
            u.setUserPassword(txtPassword.getText());
            int res = dao.addData(u);
            if (res > 0) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "User Added Successfully", ButtonType.OK);
                alert.showAndWait();
                txtUserName.getScene().getWindow().hide();
            }
        }

    }
}

