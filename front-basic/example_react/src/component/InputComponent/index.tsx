import { Dispatch, SetStateAction } from 'react'

interface Props {
    label: string;
    type: string;
    name: string;

    setter: Dispatch<SetStateAction<string>>;
    maxLength: number;
    iconClass: string;
}

export default function NaverInput(props: Props) {
    const { label, type, name, setter, maxLength, iconClass } = props;
    return (
        <div className="input-row">
            <div className="icon-cell">
                <span className={iconClass}>
                    <span className="blind">{label}</span>
                </span>
            </div>
            {/* onChange input에 있는 값이 바뀔 때마다 호출한다 */}
            {/* 사용자가 입력한 행위를 받아오기 때문에 setID로 값 전달  */}
            <input
                type={type}
                className="input-text"
                maxLength={maxLength}
                placeholder={label}
                name={name}
                onChange={(event) => setter(event.target.value)} />
        </div>
    )
}
