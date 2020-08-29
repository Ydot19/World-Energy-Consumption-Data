# World Energy Consumption API

Building out a simple API(s) that loads and analyzes world energy consumption data

## Purpose

- Build a full springboot framework
- Include test suite
- Build Github Actions
- EndPoints:
    - **GET** /historical/countries
        - List the available countries for which there is data
    - **POST** /historical/country
        - Uses a json body to return data from a specific range of years
        - Returns a single country's energy consumption totals during that range in product categories
    - **GET** /historical/products
        - Defines the energy consumption categories (Oil Products, Crude, NGL and Feedstock etc.)
    
    - **POST** /historical/product
         - Uses a json body to return data from a specific range of years
         - Returns a single product's energy consumption totals during that range in product country sorted from Largest to Smallest
      
    - **GET** /historical
        - Returns all the available data
    
    - **POST** /historical
        - Returns all the available in a given data range

## Credit

Data source: [International Energy Agency](https://www.iea.org/)