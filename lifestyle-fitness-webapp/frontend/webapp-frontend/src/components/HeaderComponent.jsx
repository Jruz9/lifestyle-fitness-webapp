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
                        <Nav.Link href='/foods'>food diet</Nav.Link>
                        <Nav.Link href='/exercise'>excerise routine</Nav.Link>                  
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