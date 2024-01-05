import React, {useRef} from 'react';
import {Task} from '../types/Task';

type Props = {
    tasks: Task[],
    setTasks: (tasks: Task[]) => void
}

export default function AddTask(props: Props) {
    const taskTitle = useRef<HTMLInputElement>(null);

    const addTask = () => {
        if (taskTitle.current === null) return;
        if (taskTitle.current.value === "") return alert("タスク名を入力してください");
        let task = {
            id: 0,
            title: taskTitle.current.value,
            completed: false
        };
        const newTasks = props.tasks.concat(task);
        props.setTasks(newTasks);
        taskTitle.current.value = "";
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
