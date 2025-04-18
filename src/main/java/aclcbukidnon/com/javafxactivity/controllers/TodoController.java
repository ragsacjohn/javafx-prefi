package aclcbukidnon.com.javafxactivity.controllers;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class TodoController {

    @FXML
    private ListView<String> todoList;

    @FXML
    public void initialize(){
        ObservableList<String> initialItems = FXCollections.observableArrayList();
        initialItems.add("add list");

        todoList.setItems(initialItems);
        todoList.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        todoList.getSelectionModel().selectedItemProperty().addListener(
                (obs, oldVal, newVal) ->
                {

                    if (newVal != null){
                        onTodoListItemClick(newVal);
                    }
                }

        );
    }


    private void onTodoListItemClick(String value){

        var dialog = new TextInputDialog(value);
        dialog.setTitle("Update Todo");


        var result = dialog.showAndWait();
        result.ifPresent(text -> System.out.println(text));
    }



    @FXML
    protected void onCreateClick(){
        var dialog = new TextInputDialog("");
        dialog.setTitle("Create New Todo");


        var result = dialog.showAndWait();
        result.ifPresent(text -> System.out.println(text));
    }

    @FXML
    protected void onDeleteClick(){

        var confirm = new Alert(Alert.AlertType.CONFIRMATION);
        confirm.setTitle("Confirmation Dialog");
        confirm.setHeaderText("Are you sure you want to delete this todo?");
        confirm.setContentText("This action cannot be undone.");

        var result = confirm.showAndWait();
        if (result.isPresent()) {
            result.get();
        }// User clicked OK
    }

    @FXML
    protected void onListEdit(){

    }
}
