import React from "react";
import {Link} from "react-router-dom";

class NavBar extends React.Component {
    render() {
        return (
            <div>
                <Link to="/">Запись на приём </Link>
                <Link to="/">Вызов врача на дом </Link>
                <Link to="/">Вызов скорой </Link>
                <Link to="/">Контакты </Link>
                <Link to="/">Услуги и цены </Link>
                <Link to="/">Специалисты </Link>
                <Link to="/">Отзывы </Link>
                <Link to="/">Новости </Link>
            </div>
        );
    }
}

export default NavBar;
