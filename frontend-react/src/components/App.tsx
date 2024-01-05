import React, {useEffect, useState} from 'react';
import TaskList from "./TaskList";
import AddTask from "./AddTask";
import {Task} from "../types/Task";
import getTasks from "../api/tasks";

export default function App() {
    const [tasks, setTasks] = useState<Task[]>([]);

    // コンポーネント起動時に全タスクを取得する
    useEffect(() => {
        const fetchTasks = async () => {
            try {
                const getTasksResponse = await getTasks();
                setTasks(getTasksResponse.tasks);
            } catch (error) {
                console.error('Error while fetching tasks:', error);
            }
        };

        fetchTasks();
    }, []);

    return (
        <div className="App">
            <h1>タスク管理アプリ</h1>
            <AddTask tasks={tasks} setTasks={setTasks}/>
            <TaskList tasks={tasks}/>
        </div>
    );
};
