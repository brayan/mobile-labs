import { StatusBar } from "expo-status-bar";
import { NavigationContainer } from "@react-navigation/native";
import { createNativeStackNavigator } from "@react-navigation/native-stack";
import { CategoriesScreen } from "./screens/CategoriesScreen/CategoriesScreen";
import CategoryDetailsScreen from "./screens/CategoryDetailsScreen";
import MealDetailsScreen from "./screens/MealDetailsScreen";
import { MealsColors } from "../../constants/colors";
import { Text } from "react-native";

const Stack = createNativeStackNavigator();

export default function Meals() {
  return (
    <>
      <StatusBar style="light" />
      <NavigationContainer>
        <Stack.Navigator
          initialRouteName="MealsCategories"
          screenOptions={{
            headerBackTitle: 'Back',
            headerStyle: {
              backgroundColor: MealsColors.primary600,
            },
            headerTintColor: MealsColors.white,
            contentStyle: {
              backgroundColor: MealsColors.primary500,
            },
          }}>
          <Stack.Screen
            name="MealsCategories"
            component={CategoriesScreen}
            options={{
              title: 'Categories',
            }}
          />
          <Stack.Screen
            name="CategoryDetails"
            component={CategoryDetailsScreen}
            options={({ route, navigation }) => {
              const categoryId = route.params.categoryId;
              return {
                title: categoryId,
              }
            }}
          />
          <Stack.Screen
            name="MealDetails"
            component={MealDetailsScreen}
            options={({ route, navigation }) => {
              const mealId = route.params.mealId;
              return {
                title: mealId,
              }
            }}
          />
        </Stack.Navigator>
      </NavigationContainer>
    </>
  );
}
