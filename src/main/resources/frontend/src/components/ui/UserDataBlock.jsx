import React, {Component} from 'react';
import ProfileImg from "./img/ProfileImg";
import InfoField from "./InfoField";

class UserDataBlock extends Component {
    render() {
        const url = "https://bigpicture.ru/wp-content/uploads/2015/11/nophotoshop29-800x532.jpg";
        const height = 250;
        const width = 250;

        return (
            <div>
                <ProfileImg url = {url} height = {height} width = {width}/>

                <InfoField fieldName="Фамилия" fieldText={this.props.data.surname}/>
                <InfoField fieldName="Имя" fieldText={this.props.data.name}/>
                <InfoField fieldName="Отчество" fieldText={this.props.data.patronymic}/>
                <InfoField fieldName="Номер телефона" fieldText="text"/>
                <InfoField fieldName="Почта" fieldText="text"/>

                {this.props.children}
            </div>
        );
    }
}

export default UserDataBlock;