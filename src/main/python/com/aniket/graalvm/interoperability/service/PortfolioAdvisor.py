#---------------------------------------
# PortfolioAdvisor class with two static methods to recommend portfolios based on attribute matching.
#---------------------------------------
import java
import numpy as np
from typing import List


# Import Java classes into Python using GraalVM's interoperability feature.
# These Java classes are from the "com.aniket.graalvm.interoperability.model" package.

# Define a Python variable "Porfolio" that references the Java class "Porfolio".
Portfolio = java.type("com.aniket.graalvm.interoperability.model.Portfolio")

# Define a Python variable "AskAdvice" that references the Java class "AskAdvice".
Project = java.type("com.aniket.graalvm.interoperability.model.AskAdvice")

# with this, we can use the "Porfolio" and "AskAdvice" variables to interact with the Java classes in your Python code.

class PortfolioAdvisor:
    @staticmethod
    def advise(askAdvice, portfolios):
        #---------------------------------------
        # Create a binary vector representing the required attributes for the askAdvice.
        #---------------------------------------
        askAdvice_vector = np.array([1 if attribute in askAdvice.attributes() else 0 for attribute in askAdvice.attributes()])

        #---------------------------------------
        # Create attribute vectors for all portfolios.
        #---------------------------------------
        portfolio_vectors = {
            portfolio: PortfolioAdvisor.computeVector(portfolio.getAttributes(), askAdvice.attributes())
            for portfolio in portfolios
        }

        #---------------------------------------
        # Calculate the Euclidean distance between the askAdvice's attribute vector and each portfolio's attribute vector.
        #---------------------------------------
        euclidean_distances = {
            portfolio: np.linalg.norm(askAdvice_vector - attribute_vector)
            for portfolio, attribute_vector in portfolio_vectors.items()
        }

        #---------------------------------------
        # Sort portfolios by their Euclidean distances in ascending order.
        #---------------------------------------
        ordered_portfolios = dict(sorted(euclidean_distances.items(), key=lambda item: item[1]))

        #---------------------------------------
        # Extract the recommended portfolios from the sorted dictionary.
        #---------------------------------------
        recommended_portfolios = list(ordered_portfolios.keys())

        return recommended_portfolios

    @staticmethod
    def computeVector(portfolio_attributes, searched_attributes):
        #---------------------------------------
        # Create a binary vector representing the presence of each attribute in the portfolio's attribute set.
        #---------------------------------------
        return np.array([1 if attribute in portfolio_attributes else 0 for attribute in searched_attributes])