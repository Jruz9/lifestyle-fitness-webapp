import axios from 'axios';

const FOOD_API_BASE_URL="http://localhost:8080/api/v1/foods";

class FoodServices{
    getFood(){
        return axios.get(FOOD_API_BASE_URL);
    }
    createFood(food){
        return axios.post(FOOD_API_BASE_URL,food)

    }
    getFoodById(foodId){
        return axios.get(FOOD_API_BASE_URL+'/'+foodId)
    }
    updateFood(foodId,food){
        return axios.put(FOOD_API_BASE_URL+'/'+foodId,food)
    }

    deleteFood(foodId){
        return axios.delete(FOOD_API_BASE_URL+'/'+foodId)
    }
}

export default new FoodServices();