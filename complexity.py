import matplotlib.pyplot as plt
import numpy as np

# data
valores = np.array([100, 200, 300, 400, 500, 600, 700, 800, 900])
tiempos = np.array([18.65, 18.78, 18.90, 19.01, 19.1, 19.13, 19.23, 19.31, 19.50])

plt.figure(figsize=(8, 5))
plt.plot(
    valores, 
    tiempos, 
    marker='o', 
    linestyle='-', 
    color='b', 
    label='tiempo')

n_log_n = valores * np.log2(valores)
n_log_n = (
    # transforma los valores en un rango de 0 a 3
    (n_log_n / max(n_log_n)) 
    # ajusta la escala a los tiempos
    * (
        max(tiempos) - 
        min(tiempos)
    )
    # desplaza la curva
    + min(tiempos)
)

plt.plot(valores, n_log_n, linestyle='--', color='r', label='O(n*log n)')

plt.xlabel('Valores (n)')
plt.ylabel('Tiempo (ms)')
plt.title('Complejidad del ordenamiento')
plt.legend()
plt.grid(True)
plt.show()
