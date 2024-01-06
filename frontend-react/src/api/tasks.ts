import axios from 'axios';
import {Task} from '../types/Task';

const API_BASE_URL = 'http://localhost:8080/api';

type GetTasksResponse = {
    tasks: Task[]
};

export async function getTasks(): Promise<GetTasksResponse> {
    try {
        const response = await axios.get(`${API_BASE_URL}/task`);
        return response.data;
    } catch (error) {
        console.error('Error while fetching tasks:', error);
        throw error;
    }
}

type CreateTaskResponse = {
    task: Task
}
export async function createTask(title: string): Promise<CreateTaskResponse> {
    try {
        const response = await axios.post(`${API_BASE_URL}/task`, {
            title,
        });
        return response.data;
    } catch (error) {
        console.error('Error while creating task:', error);
        throw error;
    }
}
