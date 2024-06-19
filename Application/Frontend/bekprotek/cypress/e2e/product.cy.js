describe('Product Tests', () => {
  it('Go to and select a product', () => {
    cy.visit('http://localhost:8080/products')
    cy.get('.cardButton').contains('View Details').click()
  })
})