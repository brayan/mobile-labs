import { Alert, Dimensions, KeyboardAvoidingView, ScrollView, StyleSheet, TextInput, useWindowDimensions, View } from "react-native";
import { useState } from "react";
import PrimaryButton from "../../../components/GuessMyNumber/PrimaryButton";
import { GuessMyNumberColors } from "../../../contants/colors";
import Title from "../../../components/GuessMyNumber/Title";
import Card from "../../../components/GuessMyNumber/Card";
import InstructionText from "../../../components/GuessMyNumber/InstructionText";

const MIN_INPUT_NUMBER = 1;
const MAX_INPUT_NUMBER = 99;

export default function StartGameScreen(props) {
  const [enteredNumber, setEnteredNumber] = useState('');
  const dimens = useWindowDimensions();

  const marginTop = dimens.height < 400 ? 30 : 100;

  function numberInputHandler(input) {
    setEnteredNumber(input);
  }

  function onConfirmInputClicked() {
    const chosenNumber = parseInt(enteredNumber);

    if (isNaN(chosenNumber) || chosenNumber < MIN_INPUT_NUMBER || chosenNumber > MAX_INPUT_NUMBER) {
      // show alert
      const title = "Invalid number!";
      const message = "Number has to be a number between 1 and 99.";

      Alert.alert(title, message, [{ text: "Okay", style: "destructive", onPress: onResetInputClicked }])
      return;
    }

    props.onPickNumber(chosenNumber);
  }

  function onResetInputClicked() {
    setEnteredNumber('');
  }

  return (
    <ScrollView style={{ flex: 1 }}>
      <KeyboardAvoidingView style={{ flex: 1 }} behavior="position">
        <View style={[styles.container, { marginTop: marginTop }]}>
          <Title>Guess My Number</Title>
          <Card>
            <InstructionText>Enter a number</InstructionText>
            <TextInput
              style={styles.numberInput}
              keyboardType="number-pad"
              maxLength={2}
              autoCapitalize="none"
              autoCorrect={false}
              onChangeText={numberInputHandler}
              value={enteredNumber}
            />
            <View style={styles.buttonsContainer}>
              <View style={styles.buttonContainer}>
                <PrimaryButton
                  style={styles.button}
                  onPress={onResetInputClicked}
                >
                  Reset
                </PrimaryButton>
              </View>
              <View style={styles.buttonContainer}>
                <PrimaryButton style={styles.button} onPress={onConfirmInputClicked}>Confirm</PrimaryButton>
              </View>
            </View>
          </Card>
        </View>
      </KeyboardAvoidingView>
    </ScrollView>
  );
}

const deviceHeight = Dimensions.get("window").height;

const styles = StyleSheet.create({
  screen: {
    flex: 1,
  },
  container: {
    flex: 1,
    marginTop: deviceHeight < 400 ? 30 : 100,
    alignItems: "center",
  },
  buttonsContainer: {
    flexDirection: 'row',
  },
  buttonContainer: {
    flex: 1
  },
  numberInput: {
    // alignSelf: "center",
    height: 50,
    width: 50,
    fontSize: 32,
    borderBottomColor: GuessMyNumberColors.accent500,
    borderBottomWidth: 2,
    color: GuessMyNumberColors.accent500,
    marginVertical: 8,
    fontWeight: 'bold',
    textAlign: 'center',
  },
  button: {
    marginTop: 32,
    paddingTop: 32,
  },
});
