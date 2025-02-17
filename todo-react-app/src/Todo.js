import React, { useState } from "react";
import {
  ListItem,
  ListItemText,
  InputBase,
  Checkbox,
  ListItemSecondaryAction,
  IconButton,
} from "@mui/material";
import { DeleteOutline } from "@mui/icons-material";

const Todo = (props) => {
  const [item, setItem] = useState(props.item);
  // ReadOnly
  const [readOnly, setReadOnly] = useState(true);
  const turnOffReadOnly = () => {
    setReadOnly(false);
  };
  const turnOnReadOnly = (e) => {
    if (e.key == "Enter") {
      setReadOnly(true);
      editItem(item);
    }
  };
  // deleteItem()함수 연결
  const deleteItem = props.deleteItem;
  // deleteEventHandler()
  const deleteEventHandler = () => {
    deleteItem(item);
  };
  // editItem() 연경
  const editItem = props.editItem;
  const editEventHandler = (e) => {
    setItem({ ...item, title: e.target.value });
  };
  // checkbox Event handler
  const checkboxEventHandler = (e) => {
    item.done = e.target.checked;
    editItem(item);
  };
  return (
    <ListItem>
      <Checkbox checked={item.done} onChange={checkboxEventHandler} />
      <ListItemText>
        <InputBase
          inputProps={{ "aria-label": "naked", readOnly: readOnly }}
          onClick={turnOffReadOnly}
          onKeyDown={turnOnReadOnly}
          onChange={editEventHandler}
          type="text"
          id={item.id}
          name={item.id}
          value={item.title}
          multiline={true}
          fullWidth={true}
        />
      </ListItemText>
      <ListItemSecondaryAction>
        <IconButton aria-label="Delete Todo" onClick={deleteEventHandler}>
          <DeleteOutline />
        </IconButton>
      </ListItemSecondaryAction>
    </ListItem>
  );
};

export default Todo;
