import React, {useRef} from 'react';
import {Task} from '../types/Task';
import {createTask} from '../api/tasks';

type Props = {
    tasks: Task[],
    setTasks: (tasks: Task[]) => void
}

export default function AddTask(props: Props) {
    const taskTitle = useRef<HTMLInputElement>(null);

    const addTask = async () => {
        if (taskTitle.current === null) return;
        if (taskTitle.current.value === "") return alert("タスク名を入力してください");

        try {
            const createTaskResponse = await createTask(taskTitle.current.value)
            const newTasks = props.tasks.concat(createTaskResponse.task);
            props.setTasks(newTasks);
            taskTitle.current.value = "";
        } catch (error) {
            console.error('Error while adding task:', error);
        }
    }

    return (
        <>
            <div>
                <input className="inputTask" type="text" ref={taskTitle} placeholder="タスク名を入力してください"/>
                <button onClick={addTask}>追加</button>
            </div>
        </>
    );
};
