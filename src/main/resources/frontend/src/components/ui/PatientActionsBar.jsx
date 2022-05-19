import React from 'react';

class PatientActionsBar extends React.Component {
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
                            Мои записи на приём
                        </button>
                    </li>

                    <li>
                        <button>Сообщения</button>
                    </li>

                    <li>
                        <button>Медицинская карта</button>
                    </li>
                </ul>
            </div>
        );
    }
}

export default PatientActionsBar;