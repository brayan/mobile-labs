import { StatusBar } from "expo-status-bar";
import { NavigationContainer } from "@react-navigation/native";
import { createNativeStackNavigator } from "@react-navigation/native-stack";
import MealsDetails from "./screens/MealsDetails";
import Categories from "./screens/Categories";

const Stack = createNativeStackNavigator();

export default function Meals() {
  return (
    <>
      <StatusBar style="dark" />
      <NavigationContainer>
        <Stack.Navigator
          initialRouteName="MealsCategories"
          screenOptions={{
            headerBackTitle: 'Back'
          }}>
          <Stack.Screen name="MealsCategories" component={Categories} />
          <Stack.Screen name="MealsDetails" component={MealsDetails} />
        </Stack.Navigator>
      </NavigationContainer>
    </>
  );
}
