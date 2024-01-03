import {useEffect, useState} from 'react';
import {getTasks} from '../api/tasks';
//import './App.css';
import {Task} from '../types/Task';

const App = () => {
    // タスク一覧の初期値を空の配列とする
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
        <div className="container">
            <h1>ToDo List</h1>
            <ul>
                {tasks.map((task: Task) => (
                    <li key={task.id}>{task.title}</li>
                ))}
            </ul>
        </div>
    );
};

export default App;
