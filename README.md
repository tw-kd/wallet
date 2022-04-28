# Wallet

### Focus: TDD, Clean Code

### Problem Statement: 
Requirements:
- As a wallet owner, I would like to be able to put money into my wallet, so that I can take it out later.
- As a wallet owner, I would like to be able to take a specified amount of money out of the wallet.

```
Given I have put in the wallet `Rs. 1` and `$1`,

When I want to take out `Rs. 10`,

Then I should be able to retrieve it even if `Rs. 10` wasn't put in, explicitly.
```
- As a wallet owner, I want to know the total money my wallet has for the preferred currency.

```
Given preferred currency is Rs.,

When my wallet has `Rs. 50` and `$1`,

Then the sum of money in the wallet is `Rs. 124.85`
```
```
Given preferred currency is $,

When my wallet has Rs. 74.85, $1 and `Rs. 149.7`, 

Then the sum of money in the wallet is `$4`
```