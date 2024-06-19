describe('To SignIn', () => {
  it('passes', () => {
    cy.visit('http://localhost:8080/signin')
    //cy.get('input[type="email"].w100').click();
    cy.get('input[type="email"].w100').type('test@test.nl');
    //cy.get('input[type="password"].w100').click();
    cy.get('input[type="password"].w100').type('test123');
    cy.get('input[type="submit"].action').click();
  })
  it('gets error', () => {
    cy.visit('http://localhost:8080/signin')
    //cy.get('input[type="email"].w100').click();
    cy.get('input[type="email"].w100').type('test@test.nl');
    //cy.get('input[type="password"].w100').click();
    cy.get('input[type="password"].w100').type('test1234');
    cy.get('input[type="submit"].action').click();
  })
})