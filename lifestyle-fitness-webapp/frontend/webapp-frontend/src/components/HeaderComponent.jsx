import React, { Component } from 'react';
import { Navbar, Nav, Container } from 'react-bootstrap';

class HeaderComponent extends Component {
    constructor(props){
        super(props)

        this.state={

        }
    }


    render() {
        return (
            <div>
                <Navbar  expand='sm' bg='dark' variant='dark'>
                <Container>
                    <Navbar.Brand href="/">Fitness App </Navbar.Brand>
                    <Navbar.Toggle aria-controls="responsive-navbar-nav" />
                    <Navbar.Collapse id='responsive-navbar-nav'>
                    <Nav>
                        <Nav.Link href='/'>Home</Nav.Link>
                        <Nav.Link href='/foods'>food List</Nav.Link>
                        <Nav.Link href='/exercise'>Exercise List</Nav.Link>
                        <Nav.Link href="/">Calorie Calculator</Nav.Link>
                    </Nav>
                    </Navbar.Collapse>
                    </Container>
                    </Navbar>

{/* 
                    <nav className='navbar navbar-expand md navbar-dark bg-dark '>
                        <div >
                            <a href='/' className='navbar-brand'>fitness app</a>
                        </div>

                    </nav> */}

            </div>
        );
    }
}

export
default HeaderComponent;