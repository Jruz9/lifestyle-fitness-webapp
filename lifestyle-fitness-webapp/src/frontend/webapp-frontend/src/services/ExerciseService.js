import axios from "axios";

const EXERCISE_API_BASE_URL="http://localhost:8080/api/v1/exercise"

class ExerciseServices{

    getAllExercises(){
        return axios.get(EXERCISE_API_BASE_URL)
    }
    createExercise(exercise){
        return axios.post(EXERCISE_API_BASE_URL,exercise)
    }
    getAllExercisesById(exerciseId){
        return axios.get(EXERCISE_API_BASE_URL+"/"+exerciseId)
    }
    updateExercise(exerciseId,exercise){
        return axios.put(EXERCISE_API_BASE_URL+"/"+exerciseId,exercise)

    }
    deleteExercise(exerciseId){
        return axios.delete(EXERCISE_API_BASE_URL+'/'+exerciseId)
    }

}

export default new ExerciseServices(); 