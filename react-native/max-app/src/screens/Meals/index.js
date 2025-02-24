import { StatusBar } from "expo-status-bar";
import { NavigationContainer } from "@react-navigation/native";
import { createNativeStackNavigator } from "@react-navigation/native-stack";
import { CategoriesScreen } from "./screens/CategoriesScreen/CategoriesScreen";
import CategoryDetailsScreen from "./screens/CategoryDetailsScreen";
import MealDetailsScreen from "./screens/MealDetailsScreen";
import { MealsColors } from "../../constants/colors";
import { createDrawerNavigator } from "@react-navigation/drawer";
import FavoritesScreen from "./screens/FavoritesScreen";
import { Ionicons } from '@expo/vector-icons';
import FavoritesContextProvider from "./store/favorites-context";
import { Provider } from "react-redux";
import { store } from "./store/redux/store";

const Stack = createNativeStackNavigator();
const Drawer = createDrawerNavigator();

function DrawerNavigator() {
  return (
    <Drawer.Navigator
      screenOptions={{
        headerStyle: {
          backgroundColor: MealsColors.primary600,
        },
        headerTintColor: MealsColors.white,
        sceneContainerStyle: {
          backgroundColor: MealsColors.primary500,
        },
        drawerContentStyle: {
          backgroundColor: MealsColors.primary600,
        },
        drawerInactiveTintColor: MealsColors.white,
        drawerActiveTintColor: MealsColors.primary500,
        drawerActiveBackgroundColor: '#E4BAA1',
      }}
    >
      <Drawer.Screen
        name="Categories"
        component={CategoriesScreen}
        options={{
          title: "Categories",
          drawerIcon: ({ color, size }) => (
            <Ionicons name="list" color={color} size={size} />
          )
        }}
      />
      <Drawer.Screen
        name="Favorites"
        component={FavoritesScreen}
        options={{
          drawerIcon: ({ color, size }) => (
            <Ionicons name="star" color={color} size={size} />
          )
        }}
      />
    </Drawer.Navigator>
  );
}

export default function Meals() {
  return (
    <>
      <StatusBar style="light" />
      <FavoritesContextProvider>
        <Provider store={store}>
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
                name="DrawerScreen"
                component={DrawerNavigator}
                options={{
                  headerShown: false,
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
        </Provider>
      </FavoritesContextProvider>
    </>
  );
}
