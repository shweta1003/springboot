import React, { Component } from 'react';
import { Navbar} from 'react-bootstrap';
import { Nav} from 'react-bootstrap';
import { NavDropdown} from 'react-bootstrap';
class App extends Component {
  handleSelect(eventKey) {
    alert(`selected ${eventKey}`);
  }

  render() {
    return (
      <Nav className="navbar navbar-expand-sm navbar-dark bg-dark">
      
      <Navbar.Brand href="#home">React-Bootstrap</Navbar.Brand>
      <Navbar.Toggle aria-controls="basic-navbar-nav" />
      <Navbar.Collapse id="basic-navbar-nav">
        <Nav className="mr-auto">
          <NavDropdown title="Home" id="basic-nav-dropdown">
            <NavDropdown title="Home 1" id="basic-nav-dropdown">
            <NavDropdown.Item href="#action/2.1">Home 1.1</NavDropdown.Item>
            <NavDropdown.Item href="#action/2.2">Home 1.2</NavDropdown.Item>
            <NavDropdown.Item href="#action/2.3">Home 1.3</NavDropdown.Item>
            <NavDropdown.Item href="#action/2.4">Home 1.4</NavDropdown.Item>
            </NavDropdown>
            <NavDropdown.Item href="#action/1.2">Home 2</NavDropdown.Item>
            <NavDropdown.Item href="#action/1.3">Home 3</NavDropdown.Item>
            <NavDropdown.Item href="#action/1.4">Home 4</NavDropdown.Item>
          </NavDropdown>
          <Nav.Link href="#link">Link</Nav.Link>
          <NavDropdown title="Contacts" id="basic-nav-dropdown">
            <NavDropdown.Item href="#action/3.1">manager</NavDropdown.Item>
            <NavDropdown.Item href="#action/3.2">HR</NavDropdown.Item>
            <NavDropdown.Item href="#action/3.3">Employee</NavDropdown.Item>
            <NavDropdown.Divider/>
            <NavDropdown.Item href="#action/3.4">Separated link</NavDropdown.Item>
          </NavDropdown>
          <Form inline>
      <FormControl type="text" placeholder="Search" className="mr-sm-2" />
      <Button variant="outline-light">Search</Button>
    </Form>
        </Nav>
        
      </Navbar.Collapse>
    </Nav>
    );
  }
}
export default App;

