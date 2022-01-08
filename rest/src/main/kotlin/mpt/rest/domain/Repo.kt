package mpt.rest.domain

import org.springframework.data.repository.PagingAndSortingRepository

interface OrdersRepository : PagingAndSortingRepository<Orders?, Long?>