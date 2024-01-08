//import './TaskList.css';
import {Task} from '../types/Task';

type Props = {
    tasks: Task[]
}

export default function TaskList(props: Props) {
    return (
        <div className="container">
            <ul>
                {props.tasks.map((task: Task) => (
                    <li key={task.id}>{task.title}</li>
                ))}
            </ul>
        </div>
    );
};
