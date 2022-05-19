import React from 'react';

class MedicalStaffActionsBar extends React.Component {
    render() {
        return (
            <div>
                <ul>
                    <li>
                        <button
                            onClick={() => this.props.changeSelectorMethod("profile")}
                        >
                            Профиль
                        </button>
                    </li>

                    <li>
                        <button>
                            Записи на приём
                        </button>
                    </li>

                    <li>
                        <button>Сообщения</button>
                    </li>
                </ul>
            </div>
        );
    }
}

export default MedicalStaffActionsBar;