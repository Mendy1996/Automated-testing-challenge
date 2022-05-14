Feature: Automated testing challenge

Scenario: connexion et recherche d'avis sur un produit
Given As a user, I open Mention website
When I login with the username <login> and password <mdp>
And I check that I can see an alert named <alertName> in the sidebar
Then I check that I can see a mention with content <mentionContent>
And I enter the keyword <word> in the search field and submit the search
Then I check that I can see a mention with content <mentionContentAfterSearch>
 Examples:
    | login | mdp | alertName| mentionContent | word | mentionContentAfterSearch |
    | "ci-test@mention.com" | "nqkNtTxdgKhJ" | "Lenovo Thinkpad" | "1511 Lenovo ThinkPad" | "VS HP Pavilion 15-eh1103AU Laptop Comparison" | "20YES00100 " |
