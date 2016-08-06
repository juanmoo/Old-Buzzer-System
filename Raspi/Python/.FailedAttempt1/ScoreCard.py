#! /usr/bin/python

from sys import argv
import os
import TallyMark as TM
home = os.getcwd()

class ScoreCard(object):

    def __init__(self):
        self.numberOfQuestions = self.__getNumberOfQuestions()
        self.categories = self.__getCategories()
        self.scoreKey = {}
        self.pointsPerQuestion = {}
        #for category in self.categories:
        #    QNumber = self.numberOfQuestions[self.categories.index(category)]
        #    self.scoreKey[category] = [TM.TallyMark()]*QNumber

    def __str__(self):
        return str(self.scoreKey)

    def __deifneLists(self):
        self.numberOfQuestions = slef.__getNumberOfQuestions()
        self.categories = self.__getCategories()
        self.scoreKey = {}
        self.pointsPerQuestion = {}
        


    def __fileToList(self):
        home = os.getcwd()
        try:
            categoryNameFile = open(home+"/Configuration/Categories.config",'r')
        except:
            print "***   NO FILE FOUND   ***"
            return
        lines = categoryNameFile.readlines();
        index = 0;
        while index<len(lines)-1:
            #if ('#Points&Penalties' in lines[index]) :

            if('#' in lines[index]):
                lines.pop(index)
                index -= 1
            index += 1
        index = 0
        while index<len(lines)-1:
            lines[index] = lines[index].strip()
            index += 1
        categoryNameFile.close()
        return lines

    def __getCategories(self):
        both = self.__fileToList()
        categories = []
        for pairs in both:
            cat = pairs.strip().split(',')[0]
            categories.append(cat)
        return categories

    def __getNumberOfQuestions(self):
        both = self.__fileToList()
        numberOfQuestions = []
        for pairs in both:
            num = int(pairs.strip().split(',')[1])
            numberOfQuestions.append(num)
        return numberOfQuestions

    def __setNumberOfPointsAndPenalties(self):
        both = self.__fileToList()
        points = []
        for pairs in both:
            num = int(pairs.strip().split(',')[2])
            numberOfQuestions.append(num)
        return numberOfQuestions


    def __getCategoryTotal(self,category):
        for things in self.scoreKey[category]:
