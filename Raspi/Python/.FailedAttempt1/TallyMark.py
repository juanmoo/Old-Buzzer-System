
class TallyMark (object):

    def __init__ (self, points, partial, penalty):
        self.tallys = {'Points':0 ,'Partial-Points':0 ,'Penalties':0}
        self.__points = points
        self.__penalty = penalty
        self.__partial = partial


    def addPoint(self):
        self.tallys['Points'] += slef.__points

    def addPartial(self):
        self.tallys['Partial-Points'] += self.__partial

    def addPenalty(self):
        self.tallys['Penalties'] += self.__penalty

    def get(self, thing):
        return self.tallys[thing]

    def set(self, thing, num):
        self.tallys[thing] = num

    def reset(self):
        for things in self.tallys:
            self.tallys[things] = 0
    def __str__(self):
        return str(self.tallys)
