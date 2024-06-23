import math
import random

import numpy as np


def generate_original_matrix():
    return np.array(
        [
            [0.890767, 0.807139, 0.742756, 0.865717, 0.555812],
            [0.807139, 0.890065, 0.715313, 0.695832, 0.488016],
            [0.742756, 0.715313, 0.674804, 0.735114, 0.419913],
            [0.865717, 0.695832, 0.735114, 0.961008, 0.602871],
            [0.555812, 0.488016, 0.419913, 0.602871, 0.632168]
        ]
    )


def generate_original_vector():
    return np.array(
        [0.407774, 0.833724, 0.131663, 0.245247, 0.840932]
    )


def berechne_konditionszahl(matrix):
    norm = max([sum([abs(i) for i in row]) for row in matrix])
    return -1


def berechne_cholesky_zerlegung(matrix, precision: int = 5):
    a = np.array(matrix)
    l = np.zeros(shape=a.shape)

    def l_ij(i, j):
        if i < j:
            return 0
        elif i == j:
            res = round(a[i][i] - sum([l[i][k] ** 2 for k in range(i)]), precision)
            res = round(res ** 0.5, precision)

            return res
        else:
            res = round(a[i][j] - sum([l[i][k] * l[j][k] for k in range(j)]), precision)
            res = round(res / l[j][j], precision)

            return res

    size = a.shape[0]
    for m in range(size):
        for n in range(m + 1):
            l[m][n] = l_ij(m, n)

    print(l)
    return l


def vorwaertseinsetzen(l, b, precision: int = 5):
    l = np.array(l)
    b = np.array(b)

    y = np.zeros(shape=b.shape)
    for i in range(y.shape[0]):
        y_val = round(b[i] - sum([l[i][j] * y[j] for j in range(i)]), precision)
        y_val = round(y_val / l[i][i], precision)
        y[i] = y_val

    return y


def rueckwaertseinsetzen(lt, y, precision: int = 5):
    lt = np.array(lt)
    y = np.array(y)

    x = np.zeros(shape=y.shape)
    for i in range(lt.shape[0] - 1, -1, -1):
        x_val = round(y[i] - sum(lt[i][j] * x[j] for j in range(lt.shape[0] - 1, i - 1, -1)), precision)
        x_val = round(x_val / lt[i][i], precision)
        x[i] = x_val

    return x


def solve_axb(A, b, precision: int = 5):
    a = np.array(A)
    b = np.array(b)

    l = berechne_cholesky_zerlegung(a, precision=precision)
    y = vorwaertseinsetzen(l, b, precision)
    x = rueckwaertseinsetzen(l.t, y, precision)

    return x


def solve_inverse(A, precision: int = 5):
    A = np.array(A)
    l = berechne_cholesky_zerlegung(A, precision=precision)

    y = np.zeros(shape=(A.shape[0],))

    for i in range(y.shape[0]):
        y_val = round(1 - sum([l[i][j] * y[j] for j in range(i)]), precision)
        y_val = round(y_val / l[i][i], precision)
        y[i] = y_val


#solve_axb(generate_original_matrix(), generate_original_vector(), precision=5)
#solve_axb(generate_original_matrix(), generate_original_vector(), precision=100)
#solve_axb([[4, 2], [2, 3]], [2, 2])
l = berechne_cholesky_zerlegung(generate_original_matrix(), 100)
Y = np.array([
    vorwaertseinsetzen(l, [1, 0, 0, 0, 0], 5),
    vorwaertseinsetzen(l, [0, 1, 0, 0, 0], 5),
    vorwaertseinsetzen(l, [0, 0, 1, 0, 0], 5),
    vorwaertseinsetzen(l, [0, 0, 0, 1, 0], 5),
    vorwaertseinsetzen(l, [0, 0, 0, 0, 1], 5),
]).T

print("Y:", Y)
