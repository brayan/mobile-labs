import { useState } from 'react';
import { Button, FlatList, StyleSheet, TextInput, View } from 'react-native';
import { StatusBar } from 'expo-status-bar';
import GoalInput from '../../components/GoalInput';
import GoalItem from '../../components/GoalItem';

export default function Goals() {
  const [isModalVisible, setModalVisible] = useState(false);
  const [goals, setGoals] = useState([]);

  function onAddGoalClicked() {
    setModalVisible(true);
  }

  function handleAddGoalPress(goalText) {
    setGoals((currentGoals) => [...currentGoals, { text: goalText, id: Math.random().toString() }]);
    setModalVisible(false);
  }

  function deleteGoalHandler(id) {
    setGoals((currentGoals) => {
      return currentGoals.filter((goal) => goal.id !== id);
    })
  }

  const onEndAddGoal = () => {
    setModalVisible(false);
  }

  return (
    <>
      <StatusBar style="light" />
      <View style={styles.appContainer}>
        <Button
          title='Add New Goal'
          color='#a065ec'
          onPress={onAddGoalClicked}
        />
        <GoalInput
          visible={isModalVisible}
          onAddGoal={handleAddGoalPress}
          onCancel={onEndAddGoal}
        />
        <View style={styles.goalsContainer}>
          <FlatList
            data={goals}
            keyExtractor={(item, index) => {
              return item.id;
            }}
            renderItem={(itemData) => {
              return <GoalItem
                item={itemData.item}
                onPressGoal={deleteGoalHandler}
              />;
            }}
          />
        </View>
      </View>
    </>
  );
}

const styles = StyleSheet.create({
  appContainer: {
    flex: 1,
    paddingTop: 50,
    paddingHorizontal: 16,
    backgroundColor: '#1e085a',
  },
  goalsContainer: {
    flex: 5,
    flexDirection: 'column'
  },
});
