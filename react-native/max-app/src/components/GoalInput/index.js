import { useState } from "react";
import { Button, Image, Modal, StyleSheet, TextInput, View } from "react-native";

export default function GoalInput(props) {
  const [goal, setGoal] = useState('');

  function handleGoalInputTextChange(text) {
    setGoal(text);
  }

  function handleAddGoalPress() {
    props.onAddGoal(goal);
    setGoal('');
  }

  return (
    <Modal visible={props.visible} animationType="slide">
      <View style={styles.inputContainer}>
        <Image
          style={styles.image}
          source={require('../../../assets/images/goal.png')}
        // source={require('/fdsa/asdf/goallll.png')}
        />
        <TextInput
          style={styles.textInput}
          placeholder='Your course goal!'
          onChangeText={handleGoalInputTextChange}
          value={goal}
        />
        <View style={styles.buttonsContainer}>
          <View style={styles.button}>
            <Button
              color="#f31282"
              title="Cancel"
              onPress={props.onCancel}
            />
          </View>
          <View style={styles.button}>
            <Button
              color="#5e0acc"
              title="Add goal"
              onPress={handleAddGoalPress}
            />
          </View>
        </View>
      </View>
    </Modal>
  );
}

const styles = StyleSheet.create({
  inputContainer: {
    flex: 1,
    flexDirection: 'column',
    justifyContent: 'center',
    alignItems: 'center', // default: streach
    padding: 16,
    backgroundColor: '#311b6b',
  },
  image: {
    width: 100,
    height: 100,
    margin: 20,
  },
  buttonsContainer: {
    flexDirection: 'row',
    marginTop: 16,
  },
  button: {
    width: 100,
    paddingHorizontal: 8,
  },
  textInput: {
    borderWidth: 1,
    borderColor: '#e4d0ff',
    borderRadius: 6,
    backgroundColor: '#e4d0ff',
    color: '#120438',
    width: '100%',
    padding: 8,
  },
});